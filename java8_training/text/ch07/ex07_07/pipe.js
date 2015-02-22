function pipe() {
    if (arguments.length == 0) {
	return;
    }
    var threadPool = java.util.concurrent.Executors.newCachedThreadPool();
    var output;
    for (i = 0; i < arguments.length; i++) {
	var process = new java.lang.ProcessBuilder(arguments[i].split(/\s+/)).start();;
	if (output) {
	    var previousOutput = output;
	    threadPool.execute(function() {
		    var input = new java.io.PrintWriter(new java.io.OutputStreamWriter(process.getOutputStream()));
		    var line;
		    while((line = previousOutput.readLine()) != null) {
			input.println(line);
		    }
		    previousOutput.close();
		    input.close();
		});
	}
	output = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
    }
    threadPool.shutdown();
    threadPool.awaitTermination(10, java.util.concurrent.TimeUnit.SECONDS);
    
    var line;
    while((line = output.readLine()) != null) {
	print(line);
    }
    return;
}

// test
pipe('find .', 'grep class', 'sort');
