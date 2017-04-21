$(document).ready(function(){
	"use strict";

    var Chat = {};

    Chat.socket = null;

    Chat.connect = (function(host) {
        if ('WebSocket' in window) {
            Chat.socket = new WebSocket(host);
        } else if ('MozWebSocket' in window) {
            Chat.socket = new MozWebSocket(host);
        } else {
            Console.log('Error: WebSocket is not supported by this browser.');
            return;
        }

        Chat.socket.onopen = function () {
            Console.log('Info: WebSocket connection opened.');
        };

        Chat.socket.onclose = function () {
            Console.log('Info: WebSocket closed.');
        };

        Chat.socket.onmessage = function (message) {
        	Console.log(message.data);
        };
    });
    //card.xudutong.com:80
    Chat.initialize = function() {
        if (window.location.protocol == 'http:') {
        	Chat.connect('ws://' + $("#hostIp").val() + '/mavenTest/server');
        } else {
        	Chat.connect('wss://' + $("#hostIp").val() + '/mavenTest/server');
        }
    };

    var Console = {};

    Console.log = (function(message) {
        var console = document.getElementById('console');
        console.innerHTML = "";
        console.innerHTML = message;
    });
    Chat.initialize();
});
		

