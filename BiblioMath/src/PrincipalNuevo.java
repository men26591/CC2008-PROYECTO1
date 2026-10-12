public class PrincipalNuevo {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        VentanaPrincipal ventana = new VentanaPrincipal(sistema);
        ventana.setVisible(true);
    }
}