import React, { useState, useEffect } from 'react';
import SockJS from 'sockjs-client';
import { Stomp } from '@stomp/stompjs';

export default function App() {
  const [currentTime, setCurrentTime] = useState(null);

  useEffect(() => {
    const connect = async () => {
      const ws = new SockJS('http://localhost:8080/ws');
      const stompClient = Stomp.over(ws);

      try {
        await stompClient.connect({}, (frame) => {
          stompClient.subscribe('/topic/currentTime', (message) => {
            setCurrentTime(message.body.toString());
          });
        });
      } catch (error) {
        console.error('WebSocket connection error:', error);
      }
    };

    connect();
  }, []);

  return (
    <div>
      {currentTime}
    </div>
  )
}