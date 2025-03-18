import * as readline from "readline";

class Analizza {
  analizzaNumeri(numeri: number[]): {
    sommaPositivi: number;
    prodottoNegativi: number;
    contaZero: number;
    contaPari: number;
    contaDispari: number;
  } {
    let sommaPositivi = 0;
    let prodottoNegativi = 1;
    let contaZero = 0;
    let contaPari = 0;
    let contaDispari = 0;

    for (const num of numeri) {
      if (num > 0) {
        sommaPositivi += num;
      } else if (num < 0) {
        prodottoNegativi *= num;
      } else {
        contaZero++;
      }

      if (num % 2 == 0) contaPari++;
      else contaDispari++;
    }

    return {
      sommaPositivi,
      prodottoNegativi,
      contaZero,
      contaPari,
      contaDispari,
    };
  }
}

let analizza = new Analizza();

//Creo l'interfaccia di readline per prendere input da terminale e per stamparlo
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

//Il primo argomento è la domanda
//Il secondo argomento è una callback che viene
// chiamata quando l'utente inserisce qualcosa e preme Invio.
rl.question("Inserisci una lista di numeri separati da spazio: ", (input) => {
  const numeri = input.split(" ").map(Number);
  const result = analizza.analizzaNumeri(numeri);

  console.log(`Somma positivi: ${result.sommaPositivi}`);
  console.log(`Prodotto negativi: ${result.prodottoNegativi}`);
  console.log(`Zeri: ${result.contaZero}`);
  console.log(`Pari: ${result.contaPari}`);
  console.log(`Dispari: ${result.contaDispari}`);

  //Chiusura del readline
  rl.close();
});
