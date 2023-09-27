const express = require('express');
const morgan = require('morgan');
const app = express();

const { quotes } = require('./data');
const { getRandomElement } = require('./utils');

const PORT = process.env.PORT || 4001;

app.use(express.static('public'));

app.get('/api/quotes/random', (req, res, next) => {
  const randomQuote = getRandomElement(quotes);
  if (randomQuote) {
    res.send({quote: randomQuote})
  } else {
    res.status(404).send()
  }
});

app.get('/api/quotes', (req, res, next) => {
  if (req.query.person) {
    const author = req.query.person
    const results = quotes.filter((quote) => {
      return quote["person"] === author
    })
    if (results.length > 0) {
      res.status(200).send({quotes: results})
    } else {
      res.status(200).send({quotes: []})
    }
  } else {
    res.status(200).send({quotes: quotes})
  }
})

app.post('/api/quotes', (req, res, next) => {
  if (req.query.quote && req.query.person) {
    const newQuote = {
      quote: req.query.quote,
      person: req.query.person
    }
    quotes.push(newQuote)
    res.status(200).send({quote: newQuote})
  } else {
    res.status(400).send()
  }
})

app.listen(PORT)