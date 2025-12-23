{PlayStation Store quiere procesar las compras realizadas por sus cliente en el año 2022.
* 
a) Implementar un modulo que lea compras de videojuegos. De cada compra se lee el 
* codigo de videojeugo, codigo de cliente, dia y mes. La lectura finaliza con 
* el cliente con el codigo de clietne 0. Se deben retornas dos estructuras de datos

i. Una estructura eficiente para la busqueda por codigo de cliente.

ii. Otra estructura que almacena la cantidad de compras realizadas en cada mes. 

b) Implementar un modulo que reciba la estructura generada en a)i, un codigo de 
* cliente y retorne todas las compras que realizo dicho cliente.
* 
c) Implementar un omdulo que reciba la estructura generada en a)ii y retorne la misma
* estructura ordenada por cantidad de mayor a menor. }

program play; 
type 
	rangodia = 1..31;
	rangomes = 1..12; 
	compra = record 
		codvideo: integer;
		codcliente: integer; 
		dia: rangodia; 
		mes: rangomes; 
	end; 

	arbol=^nodo; 
	nodo= record 
		dato: compra; 
		hi: arbol; 
		hd: arbol; 
	end; 
	
	lista=^nodolista; 
	nodolista= record 
		dato: compra; 
		sig: lista; 
	end;
	
	vector = array [rangomes] of integer; 

procedure inicializar (var v: vector); 
var 
	i: rangomes; 
begin 
	for i:= 1 to 12 do 
		v[i]:= 0; 
end; 

procedure leer (var c: compra); 
begin 
	c.codcliente:= random(10); 
	writeln (' El codigo de cliente es: ', c.codcliente); 
	if (c.codcliente <> 0) then begin 
		c.codvideo:= random (50); 
		writeln (' El codigo de videojeugo es: ', c.codvideo); 
		c.dia:= random(31)+1; 
		writeln (' El dia de la compra fue: ', c.dia); 
		c.mes:= random (12)+1; 
		writeln (' El MES de la compra fue: ', c.mes); 
	end; 
end; 

procedure insertar (var a: arbol; c: compra); 
begin 
	if (a= nil) then begin 
		new(a); 
		a^.dato:= c; 
		a^.hi:= nil; 
		a^.hd:= nil; 
	end
	else
		if (a^.dato.codcliente > c.codcliente) then 
			insertar (a^.hi, c)
		else
			insertar (a^.hd, c); 
end;


procedure cargararbol (var a:arbol; var v: vector); 
var 
	c: compra; 
begin 
	leer(c); 
	while (c.codcliente <> 0) do begin 
		v[c.mes]:= v[c.mes] + 1;
		insertar (a,c); 
		leer(c); 
	end; 
end; 

procedure agregaradelante (var l: lista; c: compra); 
var
	nue: lista; 
begin 
	new(nue); 
	nue^.dato:= c; 
	nue^.sig:= l; 
	l:= nue; 
end; 


procedure incisob (var l: lista; a: arbol; cod: integer); 
begin 
	if (a <> nil) then begin 
		if (a^.dato.codcliente = cod) then 
			agregaradelante (l, a^.dato);
		incisob(l, a^.hi, cod);
        incisob(l,a^.hd,cod); 
    end; 
end;


procedure imprimir (l: lista); 
var
	aux: lista; 
begin 
aux:= l; 
while (aux <> nil) do begin 
		writeln (' Para el cliente con el codigo: ', aux^.dato.codcliente, ' el codigo de videojuego es: ', aux^.dato.codvideo); 
		aux:= aux^.sig; 
end; 
end; 

procedure incisoc (var v: vector); 
var 
	i,j,actual: integer; 
begin 
	for i:= 2 to 12 do begin 
		actual:= v[i]; 
		j:= i-1; 
		while (j > 0) and (v[j] < actual) do begin 
			v[j+1]:= v[j];
			j:= j-1; 
		end; 
		v[j+1]:= actual; 
	end; 
end; 

var 
	v: vector; 
	a: arbol; 
	l: lista; 
	cod,i: integer; 
begin 
	l:= nil; 
	a:= nil; 
	randomize;
	inicializar (v); 
	cargararbol (a, v); 
	writeln (' Ingrese un codigo de cliente para saber la data de sus compras: '); 
	readln (cod); 
	incisob(l, a, cod); 
	imprimir (l); 
	incisoc (v); 
	for i:= 1 to 12 do 
		writeln (' Posicion: ', i, ' total: ', v[i]); 
end.
