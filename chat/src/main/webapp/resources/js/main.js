var user = {};
var socket;
$(document).ready(function () {
    var name = localStorage.getItem("name");
    var userName = localStorage.getItem("userName");
    if (name !== undefined && name!=="null" && userName !== undefined && userName!=="null") {
        join(name.trim(), userName.trim());
    }
    $("#join-form").submit(function ( event ) {
        event.preventDefault();
        var name = $("#name").val();
        var userName = $("#user-name").val();
        if(name!==undefined && name.trim()!=="" && userName!==undefined && userName.trim()!==""){
            join(name, userName);
        }
        
    });
    $("#btn-msg").click(function () {
        var msg = $("#msg").val();
        if (msg.indexOf("@") !== -1) {
            var splitMsg = msg.split(" ");
            var targetUserName = splitMsg[0].split("@")[1];
            var target = {
                userName : targetUserName,
            };
            var message = {
                message : splitMsg[1],
                user : user,
                target : target
            };
            sendChatMessage(JSON.stringify(message));
        }
    });
    
});

function join ( name, userName ) {
    var serverUrl = "ws://localhost:8080/chat/zoom/"+name+"/"+userName;
    $("#form").hide();
    $("#chat").show();
    user.name = name;
    user.userName = userName;
    localStorage.setItem("name", name);
    localStorage.setItem("userName", userName);
    createConnection(serverUrl);
}

function createConnection ( url ) {
    console.log("creating connection: ", url);
    socket = new WebSocket(url);
    socket.onmessage = function (event){
        var msg=event.data;
        console.log(msg);
    }
    console.log("socket state: ", socket.readyState);
}

function sendChatMessage ( message ) {
    console.log("sending message : ", message);
    if (socket.readyState === 1) {
        socket.send(message);
    }
}

function receiveMessage ( event ) {
    var msg = event.data;
    console.log("received msg: ", msg);
}