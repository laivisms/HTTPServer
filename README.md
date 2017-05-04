# HTTPServer A readme is included in each class, but to summarize them:

                the main server waits for a connection on a socket. When a client connects, the server sends the new socket to a runnable
                to be executed in a thread. The thread then parses the message (using antlr), then calls the correct handler for 
                 that header, maps the target to the resource, accesses the target in the computers disk (or cache), writes the correct response
                into the socket, then closes the socket. 
                
                included is a JUNIT test file with 5 JUNIT tests
                
                also, keep in mind that, since the cache is a write-back cache, some puts/posts/deletes may not immediately appear in the file system, 
                    until they are written through from the cache.
                
                
               NOT IMPLEMENTED: I implemented a logging system for crash recovery, but it was causing issues i couldnt debug. So, since
                                        the server worked better and more consistently without it, i commented out all references to the log and crash recovery.
                                        
               ALSO: I couldn't figure out how to cause antlr to return an exception when recieving a bad message. Therefore, HTTP messages
                      with incorrect formatting will often cause the server to just close the connection instead of sending a 500.
                     
