# messageMe
A simple app that send notification to itself using firebase.

This is a simple android app which writes to firbase and subscribes to the topic, it’s writing to. Thus, gets a notification. All of this, while a node server listens continuously to any node added.  

The server observes if any node is added to the hard-coded topic, if so it sends the notification to the app which is subscribed to the topic.

Server : [messageMe-server](https://github.com/Aman-B/messageMe-server)
