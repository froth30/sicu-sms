/*                                                                      *\
**                    SICU Stress Measurement System                    **
**                      Project P04  |  C380 Team A                     **
**          EBME 380: Biomedical Engineering Design Experience          **
**                    Case Western Reserve University                   **
**                          2016 Fall Semester                          **
\*                                                                      */

const byte toSlave = 2;

long cmdCount = 0;
long count = 0;

void setup() {
  pinMode(toSlave, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  count++;
  if (count >= 2^64 - 1) {
    count = 0;
    digitalWrite(toSlave, HIGH);
    Serial.print(++cmdCount);
    Serial.println(" Sent command to slave.");
  } else {
    digitalWrite(toSlave, LOW);
  }
}
