def separador=","//signo por el que se separan los campos en el archivo
def directorio=""//direccion del archivo
def archivo="access5x10x15.csv"//nombre del archivo
def salida="salida-access.txt"//nombre del archivo
def arreglo = []
def lineas


/**
 * instancioms la clase buffer reader y enviamos al metodo fileReader el directorio y el archivo
 */

lineas = new BufferedReader(new FileReader(directorio+archivo))
def bw = new BufferedWriter(new FileWriter(salida));
//recorremos las lineas con un foreach
        lineas.each { linea->
         //le hacemos un split por cada ";" a las lineas y lo guardamos en un arreglo
            arreglo = linea.split(separador)
			print arreglo[0]+"\n"
			bw.write(" DB::table('accesses')->insert([\n'person_id' => '${(arreglo[0])}',\n'closed' => 0,\n'description' => NULL,\n'delete' => false,\n'created_at'=> new DateTime,\n'updated_at'=> new DateTime\n]);");
			bw.write("\r\n");
		
            
        }
		bw.close()


