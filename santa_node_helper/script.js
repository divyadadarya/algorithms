const fs = require('fs');

// 1- what floor does santa end up on
// ( --> should go UP 1 floor
// ) --> should go DOWN 1 floor

function part1(){
	fs.readFile('./input.txt', (err, data) => {
		console.time('santa-time');
		// if(err){
		// 	console.log('Error!');
		// }
		const directions = data.toString();
		const directionsArray = directions.split('');
		const answer = directionsArray.reduce((acc, currentValue) => {
			if(currentValue === '('){
				return acc+= 1
			}
			else if(currentValue === ')'){
				return acc-=1
			}
		}, 0)
		console.timeEnd('santa-time');

		console.log('Floor is : ', answer);
	})
}

part1();

// 2 - when does santa first enter the basement

function part2(){
	fs.readFile('./input.txt', (err,data) => {
		const directions = data.toString();
		const directionsArray = directions.split('');
		let accumulator = 0;
		let counter = 0;

		const answer2 = directionsArray.some((currentItem) => {
			if(currentItem === '('){
				accumulator+= 1
			}
			else if(currentItem === ')'){
				accumulator-=1
			}

			counter ++ 
			return accumulator < 0;
		})

		console.log('basement entered at : ', counter);
	})
}

part2();