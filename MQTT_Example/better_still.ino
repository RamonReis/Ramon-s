
int analog = 0;

uint32_t lastSample = 0;
int maxVal = 0;

// the setup routine runs once when you press reset:
void setup() {
  // initialize serial communication at 9600 bits per second:
  Serial.begin(9600);
  // make the pushbutton's pin an input:
  pinMode(analog, INPUT);
}

// the loop routine runs over and over again forever:
void loop() {
  // read the input pin:
  int sensorValue = analogRead(analog);
  if (millis() - lastSample > 1000 * 3) { // Every 1s:
    lastSample = millis(); 
    Serial.println(maxVal);
    maxVal = 0;
  }
  int reading = analogRead(analog);
  if (reading > maxVal) {
      maxVal = reading;
  }
}
