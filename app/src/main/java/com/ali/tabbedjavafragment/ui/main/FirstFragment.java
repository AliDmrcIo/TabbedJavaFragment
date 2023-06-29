package com.ali.tabbedjavafragment.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviderGetKt;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ali.tabbedjavafragment.R;

public class FirstFragment extends Fragment {

    PageViewModel pageViewModel; //pageViewModel'ımı burada tanımlamam gerekiyor

    public static FirstFragment newInstance(){
        return new FirstFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) { //oncreateview içerisinde view model kullanmak için,  işlemleri hemen oluşturuldan sonra yapabilmek adına bu işlemleri oncreate altında yapmalıyım o yüzden burayı açtım
        super.onCreate(savedInstanceState);

        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class); //pageViewModel classımızı bu fragment ile bağladık. bu viewModel. Verilerin nasıl ele alınacağını yazdığımız modeli kullanma işlemini yapıyoru burada
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_first,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) { //bu; onCreateView çağırıldıktan sonra çağrılıyor. Burada kullanıcının girdiği inputu alıp pageViewModel'a göndericem ve diğer fragmanda bu gönderdiğim veriyi hemen pageViewModel'dan alıp o sayfada göstericek. Yani fragmanlar arası iletişimi çözmüş olucam. Ondan sonra da buradaki viewModel'ımı kullanarak çok yapısal bir şekilde bütün veri taşıma işlemlerimi hızlıca yapabilicem
        super.onViewCreated(view, savedInstanceState);

        EditText editText= view.findViewById(R.id.editText); //Şimdi bizim burada amacımız şu: Kullanıcı 1.fragment'ta bir şeyler yazacak ve biz daha o yazarken bunları hiç enter'a vs tıklamadan daha işlem halindeyken 2.fragment'ta göstermek istiyoruz

        editText.addTextChangedListener(new TextWatcher() { //bu anlık yazının değiştirilmesiyle gösterme işini editText'i anlık olarak dinleyerek yapabiliyoruz ve onu da bu listener methodu ile yapabiliyoruz
            //Her listener'dan aşina olduğumuz sebebiyle bu alttaki 3 methodu kendi otomatik olarak getirdi

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { //Text değişmeden önce

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { //Text değişirken...(O an)
                //Burada yapmayı istediğim şey: Şu CharSequence s değişkeninin 's' ini alıp(bu s te editText ile gönderilen stringe yapışıyor) PageViewModel'a yollamak ve sonrasında diğer fragment'ta oradan o veriyi alıp göstermek. Ancak daha viewModel yazmayı yapmadık. Şimdi yapcaz

                pageViewModel.setName(s.toString());//burada, kullanıcıdan alınan editText'in yazılırken anlık olarak verilen verisini s verisiyle pageviewModel'a gönderdik, şimdi secondFragment'tan o veriyi alıp anlık olarak göstericez
            }

            @Override
            public void afterTextChanged(Editable s) { //Text değiştikten sonra

            }
        });
    }
}