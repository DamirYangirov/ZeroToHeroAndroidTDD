package ru.easycode.zerotoheroandroidtdd

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MusicService:Service() {
    override fun onBind(intent: Intent?): IBinder? {
         //Служит для связи между другими компонентаму
        //Например Activity, это позволяет напрямую из активити получать данные или управлять
        //методами сервиса условно в режиме реального времени
        //Если привязка не требуется то метод должен возвращать null
        return null
    }

    @Deprecated("Deprecated in Java")
    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        //является основной точкой инициализации сервиса. Вызывается системой до того как сервис
        //начнет выполнение команд переданных в onStartCommand
        //перед тем как сервис будет связан компонентом onBind
    }

    override fun onStartCommand(
        intent: Intent?,
        flags: Int,
        startId: Int,
    ): Int {
        return super.onStartCommand(intent, flags, startId)
    }
}