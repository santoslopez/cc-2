# limpiar los archivos .class que encuentra o , y archivos generados por el autograder
clean:
	@echo 'Archivos eliminados: '
	find . -name "*.class" -type f
	find . -name "*.class" -type f -delete
	find . -name "*.log" -type f
	find . -name "*.log" -type f -delete
	find . -name "*.lck" -type f
	find . -name "*.lck" -type f -delete
run:
	javac *.java

info:
	@echo 'Nombre: Santos Lopez Tzoy'
	@echo 'Seccion: AN'
	@echo 'Clase: CC2 Interciclo'
	@echo 'Year: 2018'
	@echo 'Universidad Galileo'
