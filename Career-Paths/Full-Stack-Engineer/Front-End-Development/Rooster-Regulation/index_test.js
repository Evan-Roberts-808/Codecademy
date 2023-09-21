const assert = require('assert')
const Rooster = require('../index')

describe('Rooster', () => {
  describe('.announceDawn', () => {
    it('returns a rooster call', () => {
      const expected = 'cock-a-doodle-doo';
      const test = Rooster.announceDawn;
      assert.ok(test, expected);
    })
  })
  describe('.timeAtDawn', () => {
    it('returns its argument as a string', () => {
      const expected = '5';
      const test = Rooster.timeAtDawn(5);
      assert.strictEqual(expected, test)
    })
    it('throws a RangeError if passed a number less than 0', () => {
      const input = -1;
      const actual = () => Rooster.timeAtDawn(input);
      assert.throws(actual, RangeError);
    })
    it('throws a RangeError if passed a number greater than 23', () => {
      const input = 24;
      const actual = () => Rooster.timeAtDawn(input);
      assert.throws(actual, RangeError);
    })
  })
})