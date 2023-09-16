let raceNumber = Math.floor(Math.random() * 1000);
const registeredEarly = true;
const runnersAge = 80;

if(runnersAge >= 18 && registeredEarly === true) {
  raceNumber += 1000
}

if (runnersAge >= 18 && registeredEarly === true) {
  console.log(`${raceNumber} race starts at 9:30 am`)
} else if (runnersAge >= 18 && registeredEarly === false) {
  console.log(`${raceNumber} Late adults run at 11:00 am`)
} else if (runnersAge < 18) {
  console.log(`Youth regsitrants run at 12:30 pm, Race number : ${raceNumber}`);
} else {
  console.log('runner, see the registration desk');
}