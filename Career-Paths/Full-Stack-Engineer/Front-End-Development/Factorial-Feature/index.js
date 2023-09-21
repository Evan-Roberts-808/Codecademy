const Calculate = {
    factorial(input){
      return (input <= 1) ? 1 : input * this.factorial(input-1);
    }
  }
  
  module.exports = Calculate;  