package co.edu.sena.myapp
// VARIABLES
// 1 Variables Inmutables (val)
// Una variable que no se puede modificar
val nombreInmutable: String = "Juan"
val edadInmutable: Int = 30
val valorPiInmutable = 3.14159 // El compilador infiere el tipo

// 2 Variables Mutables (var)
// Una variable que se puede cambiar
var nombreMutable: String = "Juan"
nombreMutable = "Pedro" // Esto es válido

var edadMutable: Int = 30
edadMutable = 31 // Esto es válido

var valorPiMutable = 3.14159
valorPiMutable = 3.14 // Esto es válido

// 3 Tipos de Datos en Kotlin
// Tipos Numéricos
// Enteros:
// Byte (8 bits)
// Short (16 bits)
// Int (32 bits)
// Long (64 bits)
val numeroByte: Byte = 1
val numeroShort: Short = 10
val numeroInt: Int = 100
val numeroLong: Long = 1000L

// Números con Punto Flotante:
// Float (32 bits)
// Double (64 bits)
val numeroFloat: Float = 1.23F
val numeroDouble: Double = 1.23

// Tipo Carácter (Char)
val caracter: Char = 'A'

// Tipo Booleano (Boolean)
val esVerdadero: Boolean = true
val esFalso: Boolean = false

// Tipo Cadena (String)
val mensaje: String = "Hola, mundo!"

// 4 Declaración de Variables Locales
// Variables que se asignan localmente, lo que significa
// que solo se pueden usar dentro de un bloque de código específico
fun main() {
    val nombreLocal: String = "Juanito"
    var edadLocal: Int = 30
    println("Nombre: $nombreLocal, Edad: $edadLocal")
}

// 5 Tipos Anulables (Nullable Types)
// Tipo de variable que puede ser nula, indicada con el símbolo "?"
var nombreNullable: String? = "Kevin"
nombreNullable = null // Esto es válido

// 6 Inicialización Tardía (lateinit)
// Tipo de variable que se inicializa más tarde y no puede ser nula
// Se usa la palabra "lateinit" con "var"
lateinit var nombreTardio: String

fun inicializarNombreTardio() {
    nombreTardio = "Carlos"
}

// CONSTANTES
// 1 Constantes de Nivel Superior
// Las constantes se pueden declarar directamente fuera de cualquier
// clase o función en el archivo Kotlin
const val PI = 3.14159
const val MAX_AGE = 100
const val APP_NAME = "MyApp"

// 2 Constantes en un Objeto
// Las constantes también se pueden declarar dentro de un objeto
object Constantes {
    const val URL_BASE = "https://api.example.com/"
    const val TIEMPO_ESPERA = 30
}

// 3 Constantes en un Companion Object
// También se pueden declarar dentro de un companion object de una clase
// si se desea asociar una constante con una clase
class Configuracion {
    companion object {
        const val VERSION_APP = "1.0.0"
        const val IDIOMA_POR_DEFECTO = "en"
    }
}

// 4 Tipos de Datos
// Solo primitivos (Byte, Short, Int, Long, Float, Double, Char, Boolean) y String

// NULOS
// 1 Operador de Afirmación No Nula (!!)
// Con el operador "!!" se convierte una variable nullable en no nullable,
// y si esta es nula, se lanzará una NullPointerException
val longitudNombre = nombreNullable!!.length  // Lanzará una NullPointerException si 'nombreNullable' es null

// 2 Operador Elvis (?:)
// Proporciona un valor alternativo cuando la expresión es nula
val longitudNombreConElvis = nombreNullable?.length ?: 0  // Si 'nombreNullable' es null, 'longitudNombreConElvis' será 0

// 3 Operador de Safe Call (?.)
// Permite acceder a un método o propiedad de un objeto si no es nulo
// y si el objeto es nulo, el resultado será nulo
val longitudNombreSafeCall = nombreNullable?.length  // 'longitudNombreSafeCall' será null si 'nombreNullable' es null

// 4 Operador de Asignación Condicional (?.let {})
// Permite ejecutar un bloque de código solo si la variable no es nula
nombreNullable?.let { println("Nombre tiene una longitud de ${it.length}") }

// 5 Función requireNotNull()
// Lanza una IllegalArgumentException si el valor es nulo.
val nombreNoNulo = requireNotNull(nombreNullable) { "El nombre no puede ser nulo" }

// 6 Función checkNotNull()
// Similar a requireNotNull(), pero lanza una IllegalStateException.
val nombreChequeado = checkNotNull(nombreNullable) { "El nombre no puede ser nulo" }

// OPCIONALES
// En Kotlin no existe una clase "opcional", pero si es necesario,
// se puede personalizar una clase "opcional"
class Opcional<T>(private val valor: T?) {
    fun estaPresente(): Boolean = valor != null

    fun obtener(): T = valor ?: throw NoSuchElementException("No hay valor presente")

    fun siEstaPresente(accion: (T) -> Unit) {
        valor?.let(accion)
    }

    fun oDeLoContrario(otro: T): T = valor ?: otro
}

