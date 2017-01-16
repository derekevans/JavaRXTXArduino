String var1 = "Test string";
int var2 = 1;
float var3 = 2.5;

void setup() {
  //Setup serial for 57600 baud rate
  Serial.begin(57600);
}

void loop() {
  if(Serial.available()>0) {
    //read string until null terminator
    String command = Serial.readStringUntil('\0');
    //Serial.println(command);
    if(command == "><handshake><") {
      Serial.println("ArduinoUno");
    } else if(command == "><get><") {
      Serial.print(var1);
      Serial.print(",");
      Serial.print(var2);
      Serial.print(",");
      Serial.println(var3);
    } else if(command == "><set><") {
      var1 = Serial.readStringUntil('\0');
      var2 = Serial.parseInt();
      var3 = Serial.parseFloat();
    } else if(command =="><read><") {
      int i=0;
      while(i<50) {
        Serial.print(var1);
        Serial.print(",");
        Serial.print(var2);
        Serial.print(",");
        Serial.println(var3); 
        i++;
      }
      Serial.println("end");
    }
  }
}
