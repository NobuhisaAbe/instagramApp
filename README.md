# InstagramApp

### discription
インスタグラムからapiで画像を取得し表示するアプリ

### docker上での起動
docker上でnginx,app,mysqlコンテナを構築しappを起動する
```
docker-compose up
```

### GCE上での起動
docker-composeコマンドの登録
```
echo alias docker-compose="'"'docker run --rm \
    -v /var/run/docker.sock:/var/run/docker.sock \
    -v "$PWD:$PWD" \
    -w="$PWD" \
    docker/compose:1.24.0'"'" >> ~/.bashrc
```
bashのリロード
```
source ~/.bashrc
```
githubからソースコードの取得
```
git clone https://github.com/NobuhisaAbe/instagramApp.git
```
ディレクトリ変更
```
cd instagramApp
```
docker composeイメージの実行
```
docker run docker/compose:1.24.0 version
```
GCEでのdockerイメージ起動
```
docker-compose up
```


参考：https://cloud.google.com/community/tutorials/docker-compose-on-container-optimized-os

### local開発環境での起動
app起動
```
./gradlew bootRun
```
And you can run app from intelliJ IDEA
