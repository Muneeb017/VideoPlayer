package com.muneeb.videoplayer.ui.activity

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.muneeb.videoplayer.R
import com.muneeb.videoplayer.databinding.ActivityMainBinding
import com.muneeb.videoplayer.ui.activity.navViewActivitys.AboutActivity
import com.muneeb.videoplayer.ui.activity.navViewActivitys.ThemeActivity
import com.muneeb.videoplayer.ui.fragment.FoldersFragment
import com.muneeb.videoplayer.ui.fragment.VideosFragment
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.coolPinkNav)
        setContentView(binding.root)
        requestRuntimePermission()

        // for Nav Drawer
        toggle = ActionBarDrawerToggle(this, binding.root, R.string.open, R.string.close)
        binding.root.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setFragment(VideosFragment())
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.videoView -> setFragment(VideosFragment())
                R.id.folderView -> setFragment(FoldersFragment())
            }
            return@setOnItemSelectedListener true
        }
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.feedbackNav -> Toast.makeText(this, "Feedback Clicked", Toast.LENGTH_SHORT)
                    .show()

                R.id.themeNav -> startActivity(Intent(this@MainActivity, ThemeActivity::class.java))
                R.id.sortOrderNav -> Toast.makeText(this, "Sort Order Clicked", Toast.LENGTH_SHORT)
                    .show()

                R.id.aboutNav -> startActivity(Intent(this@MainActivity, AboutActivity::class.java))
                R.id.exitNav -> exitProcess(1)
            }
            return@setNavigationItemSelectedListener true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }

    private fun setFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentFL, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }

    //    for requesting permission
    private fun requestRuntimePermission(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                this, WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this@MainActivity, arrayOf(WRITE_EXTERNAL_STORAGE), 13
            )
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 13) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "Permission Granted", Toast.LENGTH_SHORT).show()
            } else {
                ActivityCompat.requestPermissions(
                    this@MainActivity, arrayOf(WRITE_EXTERNAL_STORAGE), 13
                )
            }
        }
    }

}