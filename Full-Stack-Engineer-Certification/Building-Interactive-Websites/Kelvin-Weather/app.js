// saves the current forecast in a variable called kelvin
const kelvin = 293;

// converts kelvin to celsius and stores it in a variable
let celsius = kelvin - 273;

// converts celcius to fahrenheit and stores it in a variable
let fahrenheit = celsius * (9/5) + 32;

// rounds the value down to the nearest whole number
fahrenheit = Math.floor(fahrenheit);

console.log(`the temperature is ${fahrenheit} degrees Fahrenheit`);