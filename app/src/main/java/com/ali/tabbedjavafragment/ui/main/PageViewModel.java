package com.ali.tabbedjavafragment.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {//burası, yani pageViewModel'ımız editText ile gönderilen veriyi anlık olarak mutableLiveData ile hızlı bir şekilde FirstFragment'tan aldı ve SecondFragment'tan istek geldiğinde de hemen anlık olarak verebildi

    private MutableLiveData<String> nameInput= new MutableLiveData<>(); // MutableLiveData değiştirilebilir canlı veri demektir. Bu diğer fragmentlarla çok hızlı bir şekilde iletişim kurabiliyor. Değiştirebileceğimiz bir data oluşturuyoruz, bu data üzerinde aşağıdaki set ve get fonksiyonlarıyla değişiklikler yapabiliyoruz

    public void setName(String name){ //mutableLiveData'mızın seter'ını yazdık
        nameInput.setValue(name);
    }

    public LiveData<String> getName(){ //mutableLiveData'mızın geter'ını yazdık
        return nameInput;
    }


}