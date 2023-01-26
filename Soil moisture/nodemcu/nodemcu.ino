#include <ESP8266WiFi.h>

String apiKey = "APIKEY";
const char* ssid = "***";  
const char* password = "****";  
const char* server = "api.thingspeak.com";
WiFiClient client;

void setup() {    

  Serial.begin(115200);

  pinMode(A0,INPUT);

  delay(10);

  WiFi.begin(ssid, password);

   

  while (WiFi.status() != WL_CONNECTED) {

    delay(500);

    Serial.print(".");

  }

  Serial.println("");

  Serial.println("WiFi connected");

 

}

 

 

void loop() {

  int temp1 = analogRead(A0);
  float temp;
  temp = ( 100 - ( (temp1/1023.00) * 100 ) );
  delay(90);
  Serial.println(temp);

  if (client.connect(server,80)) {  //   "184.106.153.149" or api.thingspeak.com

    String postStr = apiKey;

           postStr +="&field1=";

           postStr += String(temp);

           postStr += "\r\n\r\n";

 

     client.print("POST /update HTTP/1.1\n");

     client.print("Host: api.thingspeak.com\n");

     client.print("Connection: close\n");

     client.print("X-THINGSPEAKAPIKEY: "+apiKey+"\n");

     client.print("Content-Type: application/x-www-form-urlencoded\n");

     client.print("Content-Length: ");

     client.print(postStr.length());

     client.print("\n\n");

     client.print(postStr);

           

 

     Serial.print("Moisture Sensor Value: ");

     Serial.print(temp);

     Serial.println(" send to Thingspeak");

  }

  client.stop();

   


   Serial.println("Waiting...");    

  for(unsigned int i = 0; i < 5; i++)

  {

    delay(2000);                        

  }                      

}
