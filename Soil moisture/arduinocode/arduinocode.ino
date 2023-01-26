#include <SoftwareSerial.h>

SoftwareSerial espSerial(5, 6);
String str;

int sensorPin1 = A0; 
int sensorValue1;

void setup() {
  Serial.begin(9600);
  espSerial.begin(9600);
  
  
 
}

void loop() {

 sensorValue1 = analogRead(sensorPin1); 
 Serial.println(String(sensorValue1));
 espSerial.println(String(sensorValue1));
 delay(3000);
}
