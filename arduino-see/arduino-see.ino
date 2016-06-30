#include <SPI.h>
#include <Ethernet.h>

byte mac[] = {
  0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED
};
IPAddress ip(10, 10, 255, 123);
//10.10.255.155 (preferencial)
IPAddress gateway(10, 10, 0, 1);
IPAddress subnet(255, 255, 0, 0);

EthernetServer server(8080);

//sensores
long valorMedio = 0;
int correntPin = A0;
int p1 = 8;
int p2 = 9;
void setup() {
  pinMode(p1, INPUT);
  pinMode(p2, INPUT);
  correnteMedia();
  Ethernet.begin(mac, ip, gateway, subnet);
  server.begin();
}

void loop() {
  EthernetClient client = server.available();
  if (client) {
    boolean currentLineIsBlank = true;
    while (client.connected()) {
      //TODO O CODIGO AQUI
      client.println("HTTP/1.0 200 OK");
      client.println("Content-type:text-plain");
      client.println("");
      client.print("ar=-1");
      client.print("&");
      client.print("presenca=");
      client.print(presenca());
      client.print("&");
      client.print("porta=-1");
      client.print("&");
      client.print("luz=");
      client.println(lerCorrent());
      break;
    }
    client.stop();
  }




}
int presenca() {
  int p = digitalRead(p1);
  int P = digitalRead(p2);
  if (p == 1 || P == 1) {
    return 1;
  }
  else {
    return 0;
  }
}

int correnteMedia() {
  int PIN = A0;
  for (int i = 0; i < 10000; i++) {
    valorMedio += abs(analogRead(PIN));
    delay(1);
  }
  valorMedio /= 10000;
  Serial.print(map(valorMedio, 0, 1023, 0, 5000));
  Serial.println(" mV");
  return int(valorMedio);
}

int lerCorrent() {
  int PIN = A0;
  int corrente = 0;
  int sensibilidade = 66;

  for (int i = 0; i < 200; i++) {
    corrente += abs(analogRead(PIN) - valorMedio);
    delay(1);
  }
  corrente = map(corrente / 200, 0, 1023, 0, 5000);
  if ((float (corrente) / sensibilidade) == 0.00) {
    return 0;
  }
  else {
    return 1;
  }

}
