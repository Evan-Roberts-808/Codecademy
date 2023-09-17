// Variables
let userName = "";
const userQuestion = "Are monkeys truly the greatest animal?";
let randomNumber = Math.floor(Math.random() * 8);
let eightBall = "";

if (userName === "") {
  console.log('Hello')
} else {
  console.log(`Hello, ${userName}`)
}

console.log(userQuestion)

switch(randomNumber){
  case 0:
    eightBall = 'It is certain'
    break;
  case 1:
    eightBall = 'It is decidedly so'
    break;
  case 2:
    eightBall = 'Reply hazy try again'
    break;
  case 3:
    eightBall = 'Cannot predict now'
    break;
  case 4:
    eightBall = 'Do not count on it'
    break;
  case 5:
    eightBall = 'My sources say no'
    break;
  case 6:
    eightBall = 'Outlook not so good'
    break;
  case 7:
    eightBall = 'Signs point to yes'
    break;  
}

console.log(eightBall)