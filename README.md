# Chat
student chat assignment CS3230

Student "Chat" Assignment
Create a program with a collection of students from the class. Remember that students in the class are unique, and can therefore only be in the collection once. The Student object has a First and Last name and a score. Each of these students will be added to a Group object with one other student, and these Groups will be in an ordered collection by the first/last name of student 1 in the group.

Also, each student will contain chat responses. Each Student should have a separate collection of chat responses, each with at least 5 different responses. The responses should be ordered, as conversation responses. Per-student responses should be unique, but the same responses can be repeated in different student objects, for example both Student 1 and Student 4 can say "Hi", but only once each.

Use these Students to create conversation pairs and display the conversation between each pair as output. This is in preparation for a chat client which will begin with next weeks' labs, so make sure to use good Object Oriented principles in your design, so that you can use the methods and classes you create this week in upcoming labs. Remember also to use the correct collection types for the requirements.

The project is to be done individually, with submission by demo and uploading to GitHub. For this assignment, create your own GitHub repository to upload to, and send me the link (make sure I can view the repository). My GitHubuser ID is "tcmarsh," and the email address associated is "trevormarsh@mail.weber.edu"

Example output:

Student 1: Hello
Student 2: Hi
Student 1: Well, this is weird
...

graphical chat assignment cs3230

Building on your code from the Student chat, create a graphical application. This GUI should display the conversations of the groups in a scrollable text area that is non-interactive. Create a text area below this scrollable text box that will accept chat input. Below the input box, have a "Send" button. The chat input should respond to any click event on the button, as well as to a Ctrl+Enter (Mac: mac+Enter) keypress by moving the input to the text area above it (as though chatting). Allow multiline input in the chat input if only the enter key is pressed.

This assignment should be created as a branch of your repository, and merged into the main branch when it is ready to submit. Make sure that the branch is committed to the GitHub repo, as well as master, so that I can see the history of the branch. To push a branch to remote, you use the SourceTree "Push" command or git push from the command line.

chat client asignemnt

Create a chat server/client program, using the following specifications:

The application must first request an IP address from the user, utilizing the graphical interface. With this IP address, the client should attempt to connect to a server. The port for server connectivity in this assignment will be 8090.

If there is no server listening on that IP/port combination, or if that server responds with anything other than an "ACK\n", your application should start a new server and connect to the newly created server.

Once connected to the server, your client should display any messages that the server sends in the chat area. When a user enters a message and initiates the Send action (through the Send button or Ctrl+Enter), send those messages to the server and do not display them in the chat area. (They will be displayed as soon as the server sends the message back.)

Before displaying any of the server messages, the student "chat" from previous assignments should be displayed.

No exception handling is required except what must happen to gracefully handle connection errors. For testing, you can run your program on your own machine twice with an IP of 127.0.0.1 ("localhost"), which should function correctly and allow you to chat with yourself on the two clients.

For the server/client connection, the first message when a connection is made must come from the client and be a user name. If the username is already in use for a connection on that server, it must send a "DENY\n" message back to the client. No further handling is required from the server in this case.

If there is a separate user name from any other client, the server replies "ACK\n" and waits for any other messages from that client. Each of those client messages will be broadcast to all currently connected clients, with the name of the client who sent it prepended - "Trevor: Hello, anyone here?" if the client sent a user name of "Trevor," for example.

The input stream for the server should be read as a BufferedReader, and the output stream is written as a PrintWriter, using the println method.