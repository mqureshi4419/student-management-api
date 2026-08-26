import { useState } from 'react'
import './App.css'

function App() {

const [name, setName] = useState("")
const [age, setAge] = useState("")
const [major, setMajor] =useState("")
const [message, setMessage] = useState("")
const [createdStudent, setCreatedStudent] = useState(null)
const [students, setStudents] = useState([])

function createStudent() {

if (!name || !age || !major) {
    setMessage("Please fill in all fields.")
    return
}

if (age <= 1 || age >= 80) {
    setMessage("Please enter a valid age.")
    return
}

  const url =
    "http://localhost:8080/api/createstudent?name=" + name + "&age=" + age + "&major=" + major;

  fetch(url, {
    method: "POST"
  })
    .then(function(response) {
      if (!response.ok) {
        return response.json().then(function(errorData) {
          throw new Error(errorData.message);
        });
      }

      return response.json();
    }).then(function(student){
        setMessage("Student created successfully!");
        setCreatedStudent(student)
        setName("")
        setAge("")
        setMajor("")
    })
}

function loadStudents() {

    const url = "http://localhost:8080/api/getstudent";

    fetch(url, {
    method: "GET"
    }).then(function(response) {
        if(!response.ok) {
            return response.json().then(function(errorData) {
            throw new Error(errorData.message);
            });
        }

        return response.json();

    }).then(function(students) {
        console.log(students);
        setMessage("Students loaded successfully.");
        setStudents(students);
    })


}

function deleteStudent(id) {
    const url = "http://localhost:8080/api/deletestudent?studentId= " + id;

    fetch(url, {
    method: "DELETE"
    }).then(function(response) {
        if(!response.ok) {
            return response.json().then(function(errorData) {
            throw new Error(errorData.message);
            });
        }

        return response.json();

    }).then(function(result) {
        setStudents(
            students.filter(function(student) {
                return student.id !== id
            })
            )
    })

}





    return (
    <div className="min-h-screen bg-gray-100 flex items-center justify-center">
        <div className="bg-white p-8 rounded-xl shadow-lg w-full max-w-md">
    <h1 className="text-4xl font-bold text-blue-600 mb-4">Student Management System</h1>
    <h2 className="text-xl font-semibold text-gray-700 mb-6">Create Student</h2>

    <div className="mb-4">
        <label className="block font-medium text-gray-700">Name: </label>
        <input type="text" value={name} onChange={(event) => setName(event.target.value)}
        className="w-full border border-gray-300 rounded-lg px-3 py-2 mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"/>
    </div>

    <div className="mb-4">
        <label className="block font-medium text-gray-700">Age: </label>
        <input type="number" value={age} onChange={(event) => setAge(event.target.value)}
        className="w-full border border-gray-300 rounded-lg px-3 py-2 mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"/>
    </div>

    <div className="mb-4">
        <label className="block font-medium text-gray-700">Major: </label>
        <input type="text" value={major} onChange={(event) => setMajor(event.target.value)}
        className="w-full border border-gray-300 rounded-lg px-3 py-2 mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"/>
    </div>

    <div className="mb-4">
        <button onClick={createStudent}
        className="w-full bg-blue-600 text-white font-semibold py-2 rounded-lg hover:bg-blue-700 transition">Create Student
        </button>
    </div>

    <p className="mb-4">{message}</p>
    {createdStudent && (
        <pre>{JSON.stringify(createdStudent, null, 2)}</pre>
    )}

    <div className="mb-4">
        <button onClick={loadStudents}
        className="w-full bg-blue-600 text-white font-semibold py-2 rounded-lg hover:bg-blue-700 transition">Load Students</button>
    </div>

    <table className="w-full border-collapse">
        <thead>
            <tr>
                <th className="px-4 py-2 text-left bg-gray-100 font-semibold border-b">Name</th>
                <th className="px-4 py-2 text-left bg-gray-100 font-semibold border-b">Age</th>
                <th className="px-4 py-2 text-left bg-gray-100 font-semibold border-b">Major</th>
                <th className="px-4 py-2 text-left bg-gray-100 font-semibold border-b">Actions</th>
            </tr>
        </thead>

        <tbody>
            {students.map(function(student) {
                return (
                  <tr key={student.id} className="hover:bg-gray-50 transition">
                    <td className="px-4 py-2 border-b">{student.name}</td>
                    <td className="px-4 py-2 border-b">{student.age}</td>
                    <td className="px-4 py-2 border-b">{student.major}</td>
                    <td className="px-4 py-2 border-b">Edit <button className="hover:text-red-600"  onClick={() => deleteStudent(student.id)}>Delete</button></td>
                  </tr>
                )
              })}
        </tbody>

    </table>

    </div>
    </div>


    )


}

export default App
