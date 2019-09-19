def separador=","//signo por el que se separan los campos en el archivo
def directorio=""//direccion del archivo
def archivo="company.csv"//nombre del archivo
def salida="salida-company.txt"//nombre del archivo
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
			bw.write(" DB::table('companies')->insert([\n'id' => '${(arreglo[0])}',\n'logo' => '${(arreglo[1])}',\n'slogan' => '${(arreglo[2])}',\n'name' => '${(arreglo[3])}',\n'description' => '${(arreglo[4])}',\n'deleted' => ${(arreglo[5])},\n'created_at'=> ${(arreglo[6])},\n'updated_at'=> ${(arreglo[7])}\n]);");
			bw.write("\r\n");
		
            
        }
		bw.close()


