/*                                                                      *\
**                    SICU Stress Measurement System                    **
**                      Project P04  |  C380 Team A                     **
**          EBME 380: Biomedical Engineering Design Experience          **
**                    Case Western Reserve University                   **
**                          2016 Fall Semester                          **
\*                                                                      */

const byte fromMaster = 22;
const byte LED = 49;

int count;

byte incomingByte = 0;

void setup() {
  pinMode(fromMaster, INPUT);
  pinMode(LED, OUTPUT);
  count = 0;
  Serial.begin(9600);
}

void loop() {
  if (digitalRead(fromMaster) == HIGH) {
    Serial.println("Received command from master.");
    count = 10;
  }
  if (count > 0) {
    count--;
    digitalWrite(LED, HIGH);
  } else {
    count = 0;
    digitalWrite(LED, LOW);
  }
}
