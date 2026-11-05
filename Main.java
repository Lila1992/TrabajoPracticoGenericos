import java.util.ArrayList;
import java.util.List;

// 1. Definir una clase genérica Caja<T> que pueda almacenar cualquier tipo de objeto
class Caja<T> {
    private T contenido;

    public void guardar(T contenido) {
        this.contenido = contenido;
    }

    public T obtener() {
        return contenido;
    }

    @Override
    public String toString() {
        return "Caja contiene: [" + contenido + "] (Tipo: " + 
               (contenido != null ? contenido.getClass().getSimpleName() : "null") + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. USO DE CLASE GENÉRICA CON DISTINTOS TIPOS (SAFETY AT COMPILE TIME) ---");
        
        // Instanciación de Caja<String>
        Caja<String> cajaTexto = new Caja<>();
        cajaTexto.guardar("Shirley Torres - Programación III");
        String texto = cajaTexto.obtener(); // No requiere casting explícito
        System.out.println(cajaTexto);
        System.out.println("Valor obtenido (String): " + texto);

        // Instanciación de Caja<Integer>
        Caja<Integer> cajaNumero = new Caja<>();
        cajaNumero.guardar(2026);
        Integer numero = cajaNumero.obtener(); // No requiere casting explícito
        System.out.println(cajaNumero);
        System.out.println("Valor obtenido (Integer): " + numero);

        System.out.println("\n--- 2. COMPARACIÓN: COLECCIONES SIN GENÉRICOS (RAW TYPES) VS CON GENÉRICOS ---");

        // Colección SIN genéricos (List lista = new ArrayList();) - Riesgo de ClassCastException
        List listaSinGenericos = new ArrayList();
        listaSinGenericos.add("Texto inicial");
        listaSinGenericos.add(100); // Permite mezclar tipos sin advertencia de compilación

        System.out.println("Colección Raw Types (Sin Genéricos): " + listaSinGenericos);
        
        try {
            // Requiere casting explícito e inseguro
            String elemento1 = (String) listaSinGenericos.get(0);
            System.out.println("Elemento 0 casteado a String: " + elemento1);
            
            // Provoca error en tiempo de ejecución (ClassCastException) si intentamos castear Integer a String
            System.out.println("Intentando castear elemento 1 (Integer) a String...");
            String elemento2 = (String) listaSinGenericos.get(1); // Falla en runtime
        } catch (ClassCastException e) {
            System.out.println("❌ ERROR EN RUNTIME (ClassCastException): " + e.getMessage());
            System.out.println("Demostrado: Las colecciones sin genéricos carecen de seguridad de tipos.");
        }

        // Colección CON genéricos (Seguridad garantizada en compilación)
        List<String> listaConGenericos = new ArrayList<>();
        listaConGenericos.add("Programación III");
        // listaConGenericos.add(100); // ❌ El compilador rechaza este valor de inmediato previniendo errores futuros.

        System.out.println("\nColección Segura (Con Genéricos): " + listaConGenericos.get(0));
    }
}