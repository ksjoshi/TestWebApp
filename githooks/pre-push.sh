x=$(git diff --name-only origin/master master)
echo "Git Diff Changes are"
echo $x

git pull -r
if [[ $x = *web* ]]; then
	cd web
	echo " Current Directory is :" 
	pwd
	./gradlew clean build
	cd ..
fi
if [[ $x = *demoservicev1* ]]; then
	cd demoservicev1
	echo " Current Directory is :"
	./gradlew clean build
	cd ..
fi


