def separador=","//signo por el que se separan los campos en el archivo
def directorio=""//direccion del archivo
def archivo="people_company.csv"//nombre del archivo
def salida="salida-people_company.txt"//nombre del archivo
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
			bw.write(" DB::table('people_companies')->insert([\n'people_id' => '${(arreglo[0])}',\n'company_id' => '${(arreglo[1])}',\n'position_company' => 'Por definir',\n'contract_id' => '${(arreglo[3])}',\n'deleted'=> false,\n'created_at'=> new DateTime,\n'updated_at'=> new DateTime\n]);");
			bw.write("\r\n");
		
            
        }
		bw.close()


