/*
 * Las interfaces en java son un conjunto de directrices que una clase debe de
 * cumplir,cuando hablamos de directrices o reglas nos referimos a metodos que
 * una clase debe implementar de forma obligada si implementa una interfaz.Si
 * una interfaz tiene dos metodos, la clase que implementa esta interfaz debe
 * implementar estos dos metodos.Hay interfaces predefinidas en la API de java y
 * hay interfaces propias que nosotros hacemos.
 * 
 * 1-Una interfaz solo puede tener metodos public y abstractos y constantes(osea
 * los
 * metodos solo estan definido mas no implementados),parecidos a los metodos
 * abstractos.No tienen variables,solo constantes.
 * 
 * 2- Las interfaces no se pueden instanciar,osea no se pueden hacer objetos de
 * ellas con un new.
 * 
 * 3- cuando se crea una interfaz tambien el compilador crea un archivo .class
 * de estas interfaces.
 * 
 * 4- en las clases abstractas estas pueden tener metodos abstractos y normales
 * al tiem´po, en una interfaz esta solo puede tener metodos abstractos.
 * 
 * 5- Las interfaces se utilizan para solucionar la limitacion de java de la
 * herencia simple,osea,en java no hay herencia multiple,una clase solo puede
 * heredar de una sola clase,no de varias.Si por ejemplo quiero implementar
 * metodos en la clase Jefatura(del archivo UsoEmpleado) la cual ya hereda de la
 * clase Empleado,no puedo implementarle una clase abstracta por la limitacion
 * de la herencia multiple,en este caso implemento en la clase Jefatura una
 * interfaz con estos metodos.Una clase puede implementar varias interfaces,no
 * hay limite.Al implementar en una clase interfaces,esta se vuelve mas
 * especializada,le damos mas funcionalidad segun lo que necesitemos,estos
 * metodos son abstractos y por eso se pueden sobreescribir en la clase donde
 * los necesitemos.La sintaxis para implementar interfaces en este ejemplo
 * seria:
 * 
 * class Jefatura extends Empleado implements interfaz1,interfaz2,etc...
 * 
 * NOTA: EN LA API DE JAVA PODEMOS VER EN EL PANEL DE LAS CLASES QUE ESTAS
 * TIENEN EL NOMBRE EN LETRA NORMAL,Y HAY OTRAS QUE EL NOMBRE ESTA EN
 * CURSIVA,ESTAS DE CURSIVA NO SON CLASES,SON INTERFACES.
 * 
 * 6- en UsoEmpleado estamos almacenando datos de empleados en un array y los
 * mostramos por consola, digamos que queremos ordenar este array y que nos
 * saque los resultados por el sueldo de los empleados comenzando desde el menor
 * hasta el mayor sueldo. Podemos implementar una interfaz predefinida de la API
 * la cual se encuentra en una clase llamada Arrays,esta clase tiene un metodo
 * sort(EN REALIDAD HAY VARIOS METODOS SORT EN ESTA CLASE,ESTO ES POR LA
 * SOBRECARGA DE METODOS).
 * 
 * Estos metodos sort la API me dice que son static(debo utilizar la clase para
 * usarlos,Arrays.sort), ahora, estos metodos sort ordenan arrays de varios
 * tipos, como mi array es de tipo Empleado(osea es un array de objetos) debo
 * buscar el metodo sort que ordene arrays de objetos.Si entramos a ese metodo
 * sort en la API y vemos la descripcion,nos dira que este metodo sort que
 * ordena array de objetos debe implementar la interfaz "Comparable".Osea, en la
 * clase Empleado de donde se crea el array,debe implementar la interfaz
 * Comparable.
 * 
 * 7- si entramos a la descripcion de esta interfaz Comparable,vemos que solo
 * tiene un metodo llamado "compareTo" y este metodo compara objetos.Ahora, este
 * metodo dice que compara dos objetos, si uno es menor que el otro devuelve un
 * numero negativo,si son iguales devuelve un 0 y sis uno es mayor que el otro
 * devuelve un numero positivo.A este metodo hay que pasarle el tipo de
 * objeto(en este caso Empleado)
 * 
 * 8- listo,con esta informacion,vamos al programa y donde estamos imprimiendo
 * la informacion del array,antes de que la imprima le decimos que la ordene con
 * Arrays.sort(misEmpleados),porque asi lo especifica la documentacion en la
 * API.Luego,debo implementar la interfaz Comparable en la clase Empleado y su
 * correspondiente metodo compareTo.(v49)
 * 
 * ------------------------------------------------------
 * 
 * Listo, hasta aqui utilizamos una interfaz predefinida,vamos a ver como crear
 * nuestras propias interfaces.
 * 
 * 1- debemos recordar que las interfaces no s epueden instanciar,osea no se
 * pueden crear objetos de una interfaz asi:
 * 
 * Comparable ejemplo=new Comparable(); esto no es valido.
 * 
 * Pero si podemos utilizar el principio de sustitucion asi:
 * 
 * Comparable ejemplo=new Empleado("Antonio",35000,2002,02,04);Aqui decimos que
 * el objeto ejemplo de la interfaz comparable es de tipo Empleado.
 * 
 * Para evaluar si un objeto pertenece a una clase o a una interfaz,utilizamos
 * el metodo instanceof(), por ejemplo hacer esto:
 * 
 * if(ejemplo instanceof(Empleado)){.....}
 * 
 * * aqui podemos instanciar otro objeto tipo Empleado y a la vez usando
 * sustitucion podemos hacer un objeto de la interfaz Comparable,y utilizar
 * instanceof() para ver el tipo del objeto.
 *
 * // Empleado directorComercial = new Jefatura("Sandra", 85000, 2012, 04, 05);
 * // Comparable ejemplo = new Empleado("Ingrid", 95000, 2020, 03, 8);
 * 
 * // // esto se lee: directorCOmercial es una instancia de tipo Empleado
 * // if (directorComercial instanceof Empleado) {
 * 
 * // System.out.println("El director comercial es de tipo Jefatura");
 * // }
 * 
 * // // ejemplo es una instancia de la interfaz Comparable
 * // if (ejemplo instanceof Comparable) {
 * 
 * // System.out.println("ejemplo implementa la interfaz Comparable");
 * // }
 * 
 * 2- ya sabiendo el uso de instanceof podemos crear nuestras propias
 * interfaces,por ejemplo vamos a crear 2,una para trabajadores y otra para
 * jefes con sus correspondientes metodos.Por ejemplo la interfaz jefes tendra
 * un metodo tomarDecisiones(), cuando una clase implemente esta interfaz,debera
 * implementar este metodo.Entonces si la clase Jefatura implementa esta
 * interfaz debera desarrollar este metodo.
 * 
 * 3- PARA CREAR UNA INTERFAZ, CREAMOS UN ARCHIVO .java Y DENTRO SE PONE: public
 * interface.EL .java TAMBIEN COMIENZA CON EL NOMBRE EN MAYUSCULA COMO LAS
 * CLASES.CUANDO SE COMPILE EL PROGRAMA,EL JDK CREA UN ARCHIVO .class PARA ESTA
 * INTERFAZ.
 * 
 * 4- recordar que el metodo de la interfaz comienza con: public abstract, pero
 * se puede obviar,por defecto el jdk lo reconoce, entonces podemos poner solo
 * el tipo de dato que debe retornar y su nombre,estos metodos solo se
 * declaran,y se sobreescriben en la clase donde se implementa la interfaz.Vamos
 * a implementar nuestra interfaz en la clase Jefatura.
 * 
 * 5- por ultimo puedo ya con un objeto de tipo Jefatura utilizar el metodo de
 * la interfaz.
 * 
 * NOTA: RECORDAR QUE LA INTERFAZ ME AYUDA A QUE UNA CLASE PUEDA TENER MAS
 * FUNCIONALIDAD Y A PODER IMPLEMENTAR METODOS EN LAS CLASES AUNQUE YA HAYAN
 * HEREDADO DE OTRAS,ASI EXTENDEMOS LA FUNCIONALIDAD DE LAS CLASES Y SOLVENTAMOS
 * LA LIMITACION DE LA HERENCIA MULTIPLE EN JAVA.
 * 
 */
