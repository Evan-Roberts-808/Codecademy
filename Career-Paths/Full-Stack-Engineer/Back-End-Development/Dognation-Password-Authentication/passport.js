const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;
const bcrypt = require("bcrypt");
const helper = require("../helpers/helper");

passport.use(new LocalStrategy(
  async function(username, password, done) {
    try {
      const user = await helper.findByUsername(username);
      if (!user) {
        return done(null, false, { message: 'No user found' });
      }

      const matchedPassword = await bcrypt.compare(password, user.password);

      if (!matchedPassword) {
        return done(null, false, { message: 'Invalid password' });
      }

      return done(null, user);
    } catch (err) {
      return done(err);
    }
  }
));

passport.serializeUser(function(user, done) {
  done(null, user.id);
});

passport.deserializeUser(function(id, done) {
  helper.findById(id, function(err, user) {
    if(err) {
      return done(err);
    }
    done(null, user);
  });
});

