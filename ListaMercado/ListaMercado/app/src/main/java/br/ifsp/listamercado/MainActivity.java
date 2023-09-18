package br.ifsp.listamercado;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button addItemButton;
    private ListView itemList;
    private static List<Produto> produtos;
    private static ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemButton = findViewById(R.id.addItemButton);
        itemList = findViewById(R.id.itemList);

        produtos = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getProdutoNomes());
        itemList.setAdapter(adapter);

        // Adiciona o código para marcar como "Comprado" com um clique simples e apagar com um clique longo
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Trata o clique simples (marcar como comprado)
                marcarComoComprado(position);
            }
        });

        itemList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Trate o clique longo (apagar o item)
                apagarItem(position);
                return true; // Retorna true para indicar que o clique longo foi tratado
            }
        });

        //Redireciona para o DigitaActivity
        addItemButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DigitaActivity.class);
                startActivity(intent);
            }
        });
    }

    // Método para adicionar um produto à lista
    public static void addItem(Produto produto) {
        produtos.add(produto);
        // Atualize a lista de nomes no adapter
        adapter.clear();
        adapter.addAll(getProdutoNomes());
        adapter.notifyDataSetChanged();
    }

    // Método para obter os nomes dos produtos para exibição na lista
    private static ArrayList<String> getProdutoNomes() {
        ArrayList<String> nomes = new ArrayList<>();
        for (Produto produto : produtos) {
            String nomeCompleto = produto.getNome() + " - " + produto.getMarca() + " - Quantidade: " + produto.getQuantidade();
            nomes.add(nomeCompleto);
        }
        return nomes;
    }

    private void marcarComoComprado(int position) {
        // Verifica se a posição é válida
        if (position >= 0 && position < produtos.size()) {
            Produto produto = produtos.get(position);
            // Define o status como "Comprado"
            produto.setComprado("Comprado");
            // Atualiza a lista de nomes no adapter
            adapter.notifyDataSetChanged();
        }
    }

    private void apagarItem(int position) {
        // Verifica se a posição é válida
        if (position >= 0 && position < produtos.size()) {
            produtos.remove(position);
            // Atualize a lista de nomes no adapter
            adapter.notifyDataSetChanged();
        }
    }
}

//A atualização da lista não está funcionando corretamente. Não consegui arrumar a tempo.