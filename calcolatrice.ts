import * as readline from "readline";

class Calcolatrice {
  calcola(a: number, b: number, operatore: string): number | string {
    switch (operatore) {
      case "+":
        return a + b;
      case "-":
        return a - b;
      case "*":
        return a * b;

      case "/":
        if (b === 0) return "Errore: divisione per zero!";
        return a / b;
      default:
        return "Errore: operazione inserita errata!";
    }
  }
}

const calcolatrice = new Calcolatrice();

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question("Inserisci primo operando: ", (input1) => {
  rl.question("Inserisci secondo operando: ", (input2) => {
    rl.question("Inserisci operazione: ", (op) => {
      let result = calcolatrice.calcola(Number(input1), Number(input2), op);
      console.log(`Risultato: ${result}`);

      //Chiusura del readline
      rl.close();
    });
  });
});
