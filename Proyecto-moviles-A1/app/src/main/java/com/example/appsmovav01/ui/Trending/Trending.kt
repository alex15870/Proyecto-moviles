package com.example.appsmovav01.ui.Trending

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.appsmovav01.DetalleLibro
import com.example.appsmovav01.R
import kotlinx.android.synthetic.main.fragment_trending.*
import kotlinx.android.synthetic.main.populares.view.*


class Trending : Fragment() {

    var adapter: LibrosAdapter? = null
    var libros = ArrayList<Libro>()

    companion object {
        fun newInstance() = Trending()
    }

    private lateinit var viewModel: TrendingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)

        cargarLibros()
        adapter = LibrosAdapter(inflater.context, libros)
        gridviewTrending.adapter = adapter

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TrendingViewModel::class.java)
        // TODO: Use the ViewModel



    }

    fun cargarLibros(){
        //Cargar películas
        libros.add(Libro("Metro-2033", R.mipmap.metro, "Metro-2033", "En 2013 hay una guerra nuclear y la población superviviente de Moscú decide resguardarse en el subsuelo, dentro de metro moscovita distribuyéndose por los kilómetros de estaciones y túneles. Cada estación se ha organizado socialmente con diferentes estructuras de poder como ciudades estado y se mantiene un cierto orden con diferentes alianzas entre ellas. "))
        libros.add(Libro("The fall of reach",R.mipmap.reach, "The fall of reach","La Caída de Reach tiene lugar en el universo de Halo entre el año 2517 hasta los eventos de 2552. En el universo Halo es posible viajar más rápido que la velocidad de la luz, a través del desliespacio; un espacio donde la relatividad especial no aplica. Esto permite a los humanos colonizar cientos de planetas, los cuales son administrados por el Mando Espacial de las Naciones Unidas (UNSC o MENU en español). Sintiéndose reprimidas por el régimen autoritario del UNSC, algunas colonias se rebelan. Por temor a que los rebeldes desintegren el Consejo de Seguridad, los altos mandos militares aprueban el Proyecto SPARTAN-II; un escuadrón secreto de súper soldados para reprimir discretamente la rebelión. "))
        libros.add(Libro("Harry potter", R.drawable.harrypotter, "Harry potter", "La historia comienza con la celebración del mundo mágico. Durante muchos años, había sido aterrorizado por el malvado mago Lord Voldemort. La noche del 31 de octubre, mató a Lily y James Potter. Sin embargo, cuando intenta matar a su hijo de 1 año, Harry, la maldición asesina Avada Kedavra se vuelve sobre sí mismo. El cuerpo de Voldemort resulta destruido, pero él sobrevive: no está muerto ni vivo. Por su parte, a Harry solo le queda una cicatriz con forma de rayo en la frente que es el único remanente físico de la maldición de Voldemort. Harry es el único sobreviviente de la maldición asesina, y a raíz de la misteriosa derrota de Voldemort, el mundo mágico empieza a llamarlo como «el niño que sobrevivió». "))

    }

    class LibrosAdapter: BaseAdapter {
        var libros = ArrayList<Libro>()
        var context: Context? = null

        constructor(context: Context, libros: ArrayList<Libro>){
            this.context = context
            this.libros = libros
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var libro = libros[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as  LayoutInflater
            var vista = inflator.inflate(R.layout.fragment_trending, null)
            vista.iv_libro.setImageResource(libro.image)
            vista.tv_titulo.setText(libro.titulo)


            vista.iv_libro.setOnClickListener{
                var intent = Intent(context, DetalleLibro::class.java)
                intent.putExtra("titulo", libro.titulo)
                intent.putExtra("sinopsis", libro.sinopsis)
                intent.putExtra("image", libro.image)
                intent.putExtra("header",libro.header)
                context!!.startActivity(intent)
            }

            return vista

        }

        override fun getItem(p0: Int): Any {
            return libros[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return libros.size
        }

}
}
