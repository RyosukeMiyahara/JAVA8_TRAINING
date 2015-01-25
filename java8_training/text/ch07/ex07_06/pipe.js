function pipe() {
    if (arguments.length == 0) {
	return;
    }
    var i = 0;
    var output = $EXEC(arguments[i]);
    for (i = 1; i < arguments.length; i++) {
	output = $EXEC(arguments[i], output);
    }
    print(output);
    return;
}

// test
pipe('find .', 'grep -v class', 'sort');
