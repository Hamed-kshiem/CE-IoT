//import { Injectable } from '@angular/core';
/*
@Injectable({
  providedIn: 'root'
})
export class WebSocketServiceService {

  webSocket: WebSocket;
  chatMessages: string[] = [];

  constructor() { }

  public openWebSocket(){
    this.webSocket = new WebSocket('ws://localhost:8080/chat');

    this.webSocket.onopen = (event) => {
      console.log('Open: ', event);
    };

    this.webSocket.onmessage = (event) => {
      const chatMessageDto = JSON.parse(event.data);
      this.chatMessages.push(chatMessageDto);
      console.log('Close: ', event.data);

    };

    this.webSocket.onclose = (event) => {
     // console.log('Close: ', event);
    };
  }

  public sendMessage(chatMessageDto: string){
    this.webSocket.send(JSON.stringify(chatMessageDto));
  }

  public closeWebSocket() {
    this.webSocket.close();
  }}

  text: string;

  constructor(public webSocketService: WebSocketServiceService) {}

  ngOnInit(): void {
    this.webSocketService.openWebSocket();
  }

  ngOnDestroy(): void {
    this.webSocketService.closeWebSocket();
  }

  sendMessage() {
    const x = {
      username: 'alex121',
      firstname: 'alex',
      lastname: 'test',
      password: 'admin',
      fingerprint: 'fingerprintvalue',
    };

    this.webSocketService.sendMessage(JSON.stringify(x));
  }

  */
