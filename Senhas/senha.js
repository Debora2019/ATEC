var senhaG = 'A';
var senhaP = 'A';
var numeroG = 0;
var numeroP = 0;
var listaPrio = [];
var listaGeral = [];
var ctP = 0;
var ctG = 0;
var ctt = 0;


//*********************************************Gera senha Geral******************************************* //
function geraSenhaGeral(){
    var senha = "";
    
    if(numeroG <= 9) {
        senha = senhaG + '0' +numeroG;
    }
    else {
        senha = senhaG + numeroG;
    }
   
    if(numeroG > 99) {
        numeroG = 0;
        if(senhaG != 'Z'){
           var charCode = senhaG.charCodeAt(0);
           senhaG = String.fromCharCode(charCode + 1);
       }else
          senhaG = 'A';     
    }
    else 
     numeroG++;
     return senha;
   } 

//***********************************************Gera Senha Prioritaria******************************************* //

   function geraSenhaPrio(){
    var senha = "";
    
    if(numeroP <= 9) {
        senha = senhaP + '0' +numeroP;
    }
    else {
        senha = senhaP + numeroP;
    }
   
    if(numeroP > 99) {
        numeroP = 0;
        if(senhaP != 'Z'){
           var charCode = senhaP.charCodeAt(0);
           senhaP = String.fromCharCode(charCode + 1);
           
       }else
          senhaP = 'A';     
    }
    else 
     numeroP++;
    return senha;
   } 

//**********************************Botão Prioritario************************************/

function BtPrio(){
    var a = "";
    ctP ++;
    a = geraSenhaPrio();
    document.getElementById('senha_prio').innerHTML = "P - " + a;
    listaPrio.push(a);
}

//*********************************Botão Geral****************************************/
function BtGeral(){
    var b = "";
    ctP ++;
    b = geraSenhaGeral();
    document.getElementById('senha_geral').innerHTML = "G - " + b;
    listaGeral.push(b);
}

//**************controla as listas de 3 chamadas de prioritárias e 1 chamada geral***************/
function BtAtend(a){
var c = "";
ctt ++;
if(ctt<4 && listaPrio.length != 0){
    c =  listaPrio.shift();
    document.getElementById(a).innerHTML = "P - " + c;
   

}else if(listaGeral.length !=0){
    c = listaGeral.shift();
    document.getElementById(a).innerHTML = "G - " + c;
    ctt = 0;
}
else{document.getElementById(a).innerHTML = "acabou-se as senhas"}

return c;
}


    console.log(geraSenhaGeral());
    console.log(geraSenhaPrio());
    console.log(listaPrio);
    console.log(listaGeral);
    console.log(BtAtend());
