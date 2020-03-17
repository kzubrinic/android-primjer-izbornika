package hr.unidu.kz.primjerizbornika;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView slika;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slika = findViewById(R.id.slika);
        // registracija izbornika na komponenti
        registerForContextMenu(slika);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Obrada akcija izbornika opcija
        switch (item.getItemId()) {
            case R.id.vanjski_izbor:
                Toast.makeText(this,"Izabran je vanjski izbornik", Toast.LENGTH_LONG).show();
                return true;
            case R.id.prva_stavka:
                Toast.makeText(this,"Izabrana je prva stavka glavnog izbornika", Toast.LENGTH_LONG).show();
                return true;
            case R.id.treca_stavka:
                Toast.makeText(this,"Izabrana je stavka podizbornika", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo mi) {
        super.onCreateContextMenu(menu, v, mi);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_slika, menu);
        menu.setHeaderTitle("Izbornik na slici");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Obrada akcija kontekstualnog izbornika
        switch (item.getItemId()) {
            case R.id.m2_prva_stavka:
                slikaProbudiSe();
                return true;
            case R.id.m2_druga_stavka:
                slikaSpavaj();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void slikaProbudiSe(){
        slika.setImageDrawable(getResources().getDrawable(R.drawable.smiley2));
    }
    private void slikaSpavaj(){
        slika.setImageDrawable(getResources().getDrawable(R.drawable.smiley));
    }
}
