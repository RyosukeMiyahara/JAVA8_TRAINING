var currentAge = 0;
if ("${$ARG}".length != 0) {
    currentAge = "${$ARG[0]}";
} else if (typeof($ENV.AGE) != 'undefined') {
    currentAge = $ENV.AGE;
} else {
    currentAge = readLine('Current your age is: ');
}
currentAge = parseInt(currentAge) + 1;
print("Next year, you will be " + currentAge + " years old.");
