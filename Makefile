# limpiar los archivos .class que encuentra, y archivos generados por el autograder
clean:
	@echo 'Archivos eliminados: '
	$(RM) *.class
run:
	javac *.java