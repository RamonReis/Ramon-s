import serial
import os
import paho.mqtt.client as paho
import time

# The callback for when the client receives a CONNACK response from the server.
def on_connect(self, client, userdata, rc):
    print("Connected with result code "+str(rc))
    # Subscribing in on_connect() means that if we lose the connection and
    # reconnect then subscriptions will be renewed.
    client.subscribe(MQTT_Topic)
# The callback for when a PUBLISH message is received from the server.
def on_message(client, userdata, msg):
    print(msg.topic+" "+str(msg.payload))
# The callback for when a PUBLISH message is received from the server.
def on_message(client, userdata, msg):
    print(msg.topic+" "+str(msg.payload))

def on_publish(client, userdata, mid):
    print 'msg published to ' + MQTT_Topic

def loop(timeout, max_packets):
    while True:
        client.publish(MQTT_Topic, ser.readline())
        #time.sleep( 1 )


MQTT_Topic = "Ramonrrs/feeds/test" # "topic/digital_input" #test/topic/digital_input
broker = "127.0.0.1"
broker = "io.adafruit.com"
username='Ramonrrs'
password_ada = 'b0e37e353dc246bc86468d62c5da6d24'

port = 1883
try:
    ser = serial.Serial('/dev/serial/by-id/usb-Arduino__www.arduino.cc__0043_85235353037351715170-if00',9600)

    mypid = os.getpid()
    client_uniq = "arduino_pub_"+str(mypid)
    client = paho.Client()

    client.on_connect = on_connect
    client.on_message = on_message
    client.on_publish = on_publish
    client.loop = loop
    
    client.username_pw_set(username, password=password_ada)
    client.connect(broker, port,60)
    print 'Connected to broker'

    client.loop_forever()
    #new_thread = client.loop_start()

except Exception as e:
    print e



