def separador=","//signo por el que se separan los campos en el archivo
def directorio=""//direccion del archivo
def archivo="contracts.csv"//nombre del archivo
def salida="salida-contracts.txt"//nombre del archivo
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
			bw.write(" DB::table('contracts')->insert([\n'cod_contract' => '${(arreglo[0])}',\n'description' => '${(arreglo[1])}',\n'start_date' => '${(arreglo[2])}',\n'end_date' => '${(arreglo[3])}',\n'endowment' => ${(arreglo[4])},\n'company_id'=> ${(arreglo[5])},\n'user_id'=> '${(arreglo[6])}',\n'adm_aux_id'=> '${(arreglo[7])}',\n'admec_id'=> '${(arreglo[8])}',\n'admec_aux_id'=> '${(arreglo[9])}',\n'deleted'=> ${(arreglo[10])},\n'created_at'=> ${(arreglo[11])},\n'updated_at'=> ${(arreglo[12])}\n]);");
			bw.write("\r\n");
		
            
        }
		bw.close()


