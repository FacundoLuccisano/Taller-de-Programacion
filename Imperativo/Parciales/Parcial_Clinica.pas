{ Una clinica necesita un sistema para el procesamiento de las atenciones realizadas a los pacientes 
durante el anio 2023.

a) Implementar un modulo que lea la informacion de las atenciones y retorne un vector donde se almacenan las atenciones
agrupadas por mes. Las atenciones de cada mes deben quedar almacenadas en un arbol binario de busqueda
ordenado por DNI del paciente y solo deben almacenarse el dni del paciente y el codigo de diagnostico
De cada atencion se lee: matricula del medico, DNI del paciente, mes y diagnostico (valor enmtre L y P). La 
lectura finaliza con matricula 0. 

b) Implementar un modulo recursivo que reciba el vector generado en a) y retorne el mes con mayor cantidad 
de atenciones. 

c) Implementar un modulo que reciba el vector generado en a) y un DNI y retorne si fue atendido o no, el
paciente conn el DNI ingresado. }

program parcialdificilardovichanashe; 
type 
	atencion = record 
		matricula: integer; 
		dni: integer; 
		mes: integer; 
		diagnostico: char; 
	end; 

	regarbol = record 
		dni: integer; 
		diagnostico: char; 
	end; 
	
	arbol = ^nodo; 
	nodo = record 
		dato: regarbol; 
		hi: arbol; 
		hd: arbol; 
	end; 
	
	vector = array [1..12] of arbol; 
	
procedure leer (var a: atencion); 
var 
	v: array[1..5] of char = ('L','M','N','O','P'); 
begin 
	a.matricula := random (10); 
	if (a.matricula <> 0) then begin 
		a.dni:= random(5000)+1000; 
		writeln (' El dni del paciente es: ', a.dni); 
		a.mes:= random (12)+1; 
		writeln (' El mes del diagnostico es: ', a.mes); 
		a.diagnostico:= v[random(5)+1]; 
		writeln (' La letra del diagnostico es: ', a.diagnostico); 
	end; 
end; 

procedure inicializar (var v: vector); 
var 
	i: integer;
begin 
	for i:= 1 to 12 do 
		v[i]:= nil; 
end; 

procedure insertar (var a: arbol; at: atencion); 
begin 
	if (a= nil) then begin 
		new(a); 
		a^.dato.dni:= at.dni; 
		a^.dato.diagnostico:= at.diagnostico; 
		a^.hi:= nil; 
		a^.hd:= nil; 
	end
	else
		if (a^.dato.dni = at. dni) then 
			a^.dato.diagnostico:= at.diagnostico
		else
		if (a^.dato.dni > at.dni) then 
			insertar (a^.hi, at)
		else
			insertar (a^.hd, at); 
end; 

procedure cargararbol (var v: vector); 
var 
	a: atencion; 
begin 
	leer(a); 
	while (a.matricula <> 0) do begin 
		insertar (v[a.mes], a); 
		leer (a); 
	end; 
end; 

function contarnodos (a: arbol): integer; 
begin 
	if (a= nil) then 
		contarnodos:= 0
	else
		contarnodos:= 1 + contarnodos(a^.hi) + contarnodos(a^.hd); 
end; 

function maxatenciones (v: vector): integer; 
var 
	max, maxmes, i, cant: integer; 
begin 
	max:= -1; 
	for i:= 1 to 12 do begin 
		cant:= contarnodos(v[i]);
		if (cant > max) then begin 
			maxmes:= i;
			max:= cant; 
		end; 
	end; 
	maxatenciones:= maxmes;
end;  	

function buscar (a: arbol; dni: integer): boolean; 
begin 
	if (a = nil) then 
		buscar:= false
	else
		if (a^.dato.dni = dni) then 
			buscar:= true 
		else
			if (a^.dato.dni > dni) then 
				buscar:= buscar (a^.hi, dni)
			else
				buscar:= buscar (a^.hd, dni);
	end; 

function atendio (v: vector; dni: integer): boolean;
var 
	i: integer; 
begin 
	atendio:= false; 
	for i:= 1 to 12 do begin 
		if (not atendio) then 
			atendio:= buscar(v[i],dni);
	end; 
end;
 
var 
	v: vector; 
	dni: integer; 
begin 
	randomize;
	inicializar (v); 
	cargararbol (v); 
	writeln (' El mes que mas atenciones recibio fue el mes: ', maxatenciones(v)); 
	writeln (' Ingrese un dni para el ultimo inciso: '); 
	readln (dni); 
	writeln (' Que el DNI ingresado haya sido atendido es: ', atendio(v,dni)); 
end.
