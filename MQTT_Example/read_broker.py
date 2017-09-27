import serial
import os
import paho.mqtt.client as paho
import time

MQTT_Topic = "topic/digital_input"
broker = "127.0.0.1"

MQTT_Topic = "Ramonrrs/feeds/test"
broker = "io.adafruit.com"
username='Ramonrrs'
password_ada = 'b0e37e353dc246bc86468d62c5da6d24'
port = 1883
#ser = serial.Serial('/dev/serial/by-id/usb-Arduino__www.arduino.cc__0043_85235353037351715170-if00',9600)

def on_connect(self, client, userdata, rc):
    print("Connected with result code "+str(rc))
    # Subscribing in on_connect() means that if we lose the connection and
    # reconnect then subscriptions will be renewed.
    #client.subscribe(MQTT_Topic)

# The callback for when a PUBLISH message is received from the server.
def on_message(client, userdata, msg):
    print('Received message ' + msg.topic+": "+str(msg.payload))
    if int(msg.payload) > 1000:
        os.system('systemctl suspend')
'''
def loop(timeout, max_packets):
    while True:
        print client.subscribe(MQTT_Topic)
'''
try:
    client = paho.Client()

    client.on_connect = on_connect
    client.on_message = on_message
    
    client.username_pw_set(username, password=password_ada)
    client.connect(broker, port, 60)
    print 'Connected to broker'
    print client.subscribe(MQTT_Topic)
    print "Subscribed to '" + MQTT_Topic + "'"
    
    #client.loop = loop
    client.loop_forever()

except Exception as e:
    print e