var assert = require("assert");
var Calculate =  require('../index.js')

describe('Calculate', () => {
  describe('.factorial', () => {
    it('will test to see if the output of 5! is equal to 120', () => {
      const expected = 120
      const test = Calculate.factorial(5)
      assert.equal(test, expected)
    })
    it('will test to see if the output of 5! is equal to 120', () => {
      const expected = 6
      const test = Calculate.factorial(3)
      assert.equal(test, expected)
    })
    it('returns 1 when you pass in 0', () => {
      const expected = 1;
      const test = Calculate.factorial(0)
      assert.equal(test, expected)
    })
  });
});