{La biblioteca de Sarmiento necesita un sistema para obtener estadisticas sobre los libros prestados. 
De cada prestamo se conoce: el numero de prestamo, ISBN del libro y codigo de socio. La lectura finaliza
con codigo de socio 0 y todos los prestamos realizados a un mismo socio se leen consecutivamente.
a) Implementar un modulo que lea la informacion de los prestamos y genere: 
i. Una estructura de datos eficiente para la busqueda por ISBN del libro.
ii. Una estructura donde se almacenan codigos de socios junto a su cantidad de prestamos.

b) Implementar un modulo que reciba la estructura generada a) y un ISBN y retorne la cantidad de 
prestamos de ese ISBN.

c) Realizar un modulo recursivo que reciba la estructura generada en a) ii y un valor X y retorne 
la cantidad de socios con candatidad de prestamos superior al valor X. }

program intriga; 
type 
	prestamo = record 
		numprestamo: integer; 
		isbn: integer; 
		codsocio: integer;
	end; 

	arbol = ^nodo; 
	nodo = record 
		dato: prestamo; 
		hi: arbol; 
		hd: arbol; 
	end; 

	reglista = record 
		codsocio: integer; 
		cant: integer; 
	end;

	lista = ^nodolista; 
	nodolista = record
		dato: reglista; 
		sig: lista; 
	end; 

procedure leer (var p: prestamo); 
begin 
	p.codsocio:= random (10); 
	writeln (' El codigo de socio: ', p.codsocio); 
	if (p.codsocio <> 0) then begin 
		p.numprestamo:= random(10); 
		writeln ('El numero de prestamo es: ', p.numprestamo); 
		p.isbn:= random (10); 
		writeln (' El isbn es: ', p.isbn); 
	end; 
end; 

procedure insertar (var a: arbol; p: prestamo); 
begin 
	if (a = nil) then begin 
		new(a); 
		a^.dato:= p; 
		a^.hi:= nil; 
		a^.hd:= nil; 
	end
	else
		if (a^.dato.isbn > p.isbn) then 
			insertar (a^.hi, p)
		else
			insertar (a^.hd, p); 
end; 


procedure agregaradelante (var l: lista; actual: integer; cant: integer); 
var 
	nue: lista; 
begin 
	new(nue); 
	nue^.dato.codsocio:= actual; 
	nue^.dato.cant:= cant; 
	nue^.sig:= l; 
	l:= nue; 
end; 

procedure cargararbolylista (var a: arbol; var l: lista); 
var 
	p: prestamo; 
	cant, actual: integer; 
begin 
	leer(p); 
	while (p.codsocio <> 0) do begin 
		cant:= 0; 
		actual:= p.codsocio; 
		while (p.codsocio <> 0) and (p.codsocio = actual) do begin 
			cant:= cant + 1; 
			insertar (a,p);
			leer(p); 
		end; 
		agregaradelante (l, actual, cant); 
	end; 
end; 

procedure imprimir (l: lista); 
begin 
	while (l<> nil) do begin 
		writeln (' Para el socio con el codigo: ', l^.dato.codsocio, ' la cantidad de prestamos es de: ', l^.dato.cant); 
		l:= l^.sig; 
	end; 
end; 

function incisob (a: arbol; isbn: integer): integer; 
begin 
	if (a = nil) then 
		incisob:= 0
	else
		if (a^.dato.isbn = isbn) then 
			incisob:= 1 + incisob(a^.hi, isbn) + incisob(a^.hd, isbn) 
		else
			if (a^.dato.isbn > isbn) then 
				incisob:= incisob(a^.hi, isbn)
			else
				incisob:= incisob(a^.hd,isbn);
end; 


function incisoc (l: lista; x: integer): integer;
begin 
	if (l= nil) then
		incisoc:= 0
	else
		if (l^.dato.cant > x) then 
			incisoc:= 1+ incisoc(l^.sig, x)
		else
			incisoc:= incisoc (l^.sig, x); 
end; 

var
	a: arbol; 
	l: lista; 
	isbn, x: integer;
begin 
	a:= nil; 
	l:= nil; 
	randomize; 
	cargararbolylista (a, l); 
	imprimir (l); 
	writeln (' Ingrese un ISBN para saber la cantidad de prestamos: '); 
	readln (isbn); 
	writeln (' La cantidad de prestamos al ISBN: ', isbn, ' es de: ', incisob(a, isbn)); 
	writeln (' Ingrese un valor X: '); 
	readln (x); 
	writeln (' La cantidad de socios con mayor cantidad de: ', x, ' prestamos es de: ', incisoc (l,x)); 
end.
