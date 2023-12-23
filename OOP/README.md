import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.text.ParseException;: Mengimpor kelas ParseException dari paket java.text. Kelas ini digunakan untuk menangani kesalahan yang terjadi saat parsing (mengubah) format tanggal.

import java.text.SimpleDateFormat;: Mengimpor kelas SimpleDateFormat dari paket java.text. Kelas ini memungkinkan kita untuk memformat dan mem-parsing tanggal.

import java.util.*;: Mengimpor semua kelas dari paket java.util, yang mencakup kelas-kelas umum seperti Scanner, List, dan ArrayList.

-------------------------------------------------
Asset:
Kelas Asset digunakan untuk merepresentasikan setiap aset dalam program. Aset memiliki atribut seperti nama aset (assetName), ID aset (assetId), jumlah (amount), harga pemeliharaan (maintenancePrice), tanggal pemeliharaan (maintenanceDate), dan status pemeliharaan (maintenanceStatus).

App:
Kelas App berfungsi sebagai pengelola utama program. Ini berisi fungsi-fungsi yang terkait dengan manajemen aset, serta fungsi utama program. Berikut adalah penjelasan singkat untuk setiap fungsi:

main: Fungsi utama yang menjalankan program. Program ini berjalan dalam loop tak terbatas hingga pengguna memilih untuk keluar.

manageAssets: Mengelola fungsi input, edit, dan delete aset. Terdapat sub-menu dengan pilihan untuk input, edit, delete, dan kembali ke menu utama.

inputAsset: Memungkinkan pengguna memasukkan data untuk membuat aset baru.

editAsset: Memungkinkan pengguna mengedit aset berdasarkan ID. Menampilkan daftar aset sebelumnya untuk membantu pengguna memilih aset yang akan diedit. Juga memberikan opsi untuk mengubah status pemeliharaan.

deleteAsset: Memungkinkan pengguna menghapus aset berdasarkan ID. Menampilkan daftar aset sebelumnya untuk membantu pengguna memilih aset yang akan dihapus.

listAssets: Menampilkan daftar aset yang telah dimasukkan. Daftar ini diurutkan berdasarkan tanggal pemeliharaan dari yang terawal hingga terakhir.

searchAssetsByDate: Memungkinkan pengguna mencari aset berdasarkan tanggal. Pengguna diminta untuk memasukkan tanggal (dd-mm-yyyy, mm-yyyy, atau yyyy), dan program akan menampilkan aset yang sesuai dengan kriteria tersebut.

listAssets: Fungsi ini bertujuan untuk menampilkan daftar aset yang telah dimasukkan. Daftar aset diurutkan berdasarkan tanggal pemeliharaan dari yang terawal hingga terakhir. Fungsi ini menggunakan metode Collections.sort untuk mengurutkan daftar aset berdasarkan tanggal pemeliharaan.

searchAssetsByDate: Fungsi ini memungkinkan pengguna mencari aset berdasarkan tanggal. Pengguna diminta untuk memasukkan tanggal dalam format tertentu (dd-mm-yyyy, mm-yyyy, atau yyyy). Program kemudian menampilkan aset yang sesuai dengan kriteria tanggal yang dimasukkan oleh pengguna.